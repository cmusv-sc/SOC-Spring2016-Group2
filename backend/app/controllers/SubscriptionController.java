package controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import models.*;
import play.libs.Json;
import play.mvc.*;
import java.util.*;

public class SubscriptionController extends Controller{
	public Result loadSubscriptionList(String category) {	
		// Long followerId=Http.Request.current().cookies.get("username");
		Long followerId=new Long(1); 
		
		List<Long> followeeIds=Subscription.findFolloweeIdByCategory(followerId, category);
        return ok(followeeIds+"");
    }

    
}