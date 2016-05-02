package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.*;
import play.mvc.*;

import java.util.ArrayList;
import java.util.List;
import play.libs.Json;
import util.Common;

/**
 * Created by Meng on 4/22/16.
 */
public class UserGroupController extends Controller {

    //get group list based on its type( public or private)
    public  Result getGroupList(String grouptype){
        ArrayList<UserGroup> group_list = new ArrayList<UserGroup>();
        List<UserGroup> list = UserGroup.find.where().eq("type", grouptype).findList();
        for (int i = 0; i < list.size(); i++){
            group_list.add(list.get(i));
        }
        return ok(Json.toJson(group_list));
    }
    //get user's private groups
    public  Result getOwnGroup(String memberid){
        ArrayList<UserGroup> group_list = new ArrayList<UserGroup>();
        List<GroupMember> list = GroupMember.find.where().eq("member_id",memberid).findList();
        for (int i = 0; i < list.size(); i++){
            Long groupid = list.get(i).group_id;
            List<UserGroup> gl = UserGroup.find.where().eq("id", groupid).findList();
            group_list.add(gl.get(0));
        }
        return ok(Json.toJson(group_list));
    }

    //get a group detail based on its name
    public  Result getGroupDetail(String groupname){
        Long groupid = UserGroupController.getGroupID(groupname);
        List<UserGroup> list = UserGroup.find.where().eq("id", groupid).findList();
        return ok(Json.toJson(list.get(0)));
    }


    //get group id based on group name;
    public static Long getGroupID (String groupname){
        List<UserGroup> list = UserGroup.find.where().eq("groupname", groupname).findList();
        return list.get(0).id;
    }
    //get group id based on group name;
    public static String getGroupName (Long group_id){
        List<UserGroup> list = UserGroup.find.where().eq("id", group_id).findList();
        return list.get(0).groupname;
    }
    public static String getGroupCreater (String groupname){
        List<UserGroup> list = UserGroup.find.where().eq("groupname", groupname).findList();
        return list.get(0).createrid;
    }
    //get group messages based on group name
    public  Result getGroupMessage(String groupname){
        Long groupid = UserGroupController.getGroupID(groupname);
        List<GroupMessage> list = GroupMessage.find.where().eq("group_id", groupid).findList();
        return ok(Json.toJson(list));
    }

    //get group member lists based on group name
    public  Result getGroupMember(String groupname){
        Long groupid = UserGroupController.getGroupID(groupname);
        List<GroupMember> list = GroupMember.find.where().eq("group_id", groupid).findList();
        return ok(Json.toJson(list));
    }
    //get notification based on userid
    public  Result getNotifcation(String userid){
        List<GroupNotice> list = GroupNotice.find.where().eq("receiver", userid).findList();
        for (int i = 0; i < list.size(); i++){
            Long groupid = list.get(i).group_id;
            String groupname = UserGroupController.getGroupName(groupid);
            list.get(i).setGroupname(groupname);
        }
        return ok(Json.toJson(list));
    }
    /*
    //if a user belongs to group member
    public Result ifGroupMemver(String groupname, Long memberid){
        Long groupid = UserGroupController.getGroupID(groupname);
        List<GroupMember> list = GroupMember.find.where().eq("group_id", groupid).eq("member_id", memberid).findList();
        if(list.size()!=0){
            return ok(Json.toJson("true"));
        }else{
            return ok(Json.toJson("false"));
        }
    }
*/
    public Result saveGroup() {
        JsonNode jsonNode = request().body().asJson();
        if(jsonNode == null) {
            return Common.badRequestWrapper("no request body");
        }
        String createrid = jsonNode.path("createrid").asText();
        String groupname = jsonNode.path("groupname").asText();
        String intro = jsonNode.path("intro").asText();
        String type = jsonNode.path("type").asText();
        System.out.print(type);

        new UserGroup( createrid, groupname, intro,type).save();
        //save creater as a group member
        if(type.equals("privategroup")) {
            System.out.print( "it is private" );
            Long groupid = UserGroupController.getGroupID(groupname);
            new GroupMember(createrid, groupid).save();
        }
        return ok(Json.toJson("new group saved"));
    }
    public Result saveMessage() {
        JsonNode jsonNode = request().body().asJson();
        if(jsonNode == null) {
            return Common.badRequestWrapper("no request body");
        }
        String createrid = jsonNode.path("createrid").asText();
        String groupname = jsonNode.path("groupname").asText();
        String title = jsonNode.path("title").asText();
        String msg = jsonNode.path("msg").asText();
        Long groupid = UserGroupController.getGroupID(groupname);
        new GroupMessage(createrid, groupid,title,msg ).save();

        return ok(Json.toJson("new msg saved"));
    }

    public Result saveNotification() {
        JsonNode jsonNode = request().body().asJson();
        if(jsonNode == null) {
            return Common.badRequestWrapper("no request body");
        }
        String sender_id = jsonNode.path("sender").asText();
        String groupname = jsonNode.path("groupname").asText();
        Long group_id = UserGroupController.getGroupID(groupname);
        String createrid = UserGroupController.getGroupCreater(groupname);
        new GroupNotice(sender_id,group_id,createrid ).save();

        return ok(Json.toJson("new notice saved"));
    }
    public Result resNotification(){
        JsonNode jsonNode = request().body().asJson();
        if(jsonNode == null) {
            return Common.badRequestWrapper("no request body");
        }
        long request_id = jsonNode.path("requestid").asLong();
        String result = jsonNode.path("response").asText();
        /*
        List<GroupNotice> list = GroupNotice.find.where().eq("id",request_id).findList();
        if(result.equals("OK")){
            new GroupMember(list.get(0).sender, list.get(0).group_id).save();
            list.get(0).delete();
        }else if(result.equals("Delete")){
            list.get(0).delete();
        }*/
        List<GroupNotice> list = GroupNotice.find.where().eq("id",request_id).findList();
        //Receiver a;
        if(result.equals("OK")){
            Receiver a = new Receiver(new ConfirmStrategy());
            a.dealwith(list,request_id);

        }else {

            Receiver b = new Receiver(new DeleteStrategy());
            b.dealwith(list,request_id);

        }

        return ok(Json.toJson("response OK"));
    }

//DESIGN PATTERN: STRATEGY

    class Receiver {
        private RequestStrategy strategy;

        public Receiver(RequestStrategy strategy) {
            this.strategy = strategy;
        }

        public void dealwith(List<GroupNotice> list,long request_id) {
            this.strategy.dealwithRes(list,request_id);
        }
        // Set Strategy
        public void setStrategy(RequestStrategy strategy) {
            this.strategy = strategy;
        }

    }

    interface RequestStrategy {
         void dealwithRes(List<GroupNotice> list,long request_id);
    }

    class ConfirmStrategy implements RequestStrategy {

        @Override
        public void dealwithRes(List<GroupNotice> list,long request_id) {
            new GroupMember(list.get(0).sender, list.get(0).group_id).save();
            list.get(0).delete();
        }
    }

    class DeleteStrategy implements RequestStrategy {

        @Override
        public void dealwithRes(List<GroupNotice> list,long request_id) {
            list.get(0).delete();
        }

    }
}
