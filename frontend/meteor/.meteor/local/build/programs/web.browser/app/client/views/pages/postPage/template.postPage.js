(function(){
Template.__checkName("post");
Template["post"] = new Template("Template.post", (function() {
  var view = this;
  return HTML.DIV({
    "class": "wrapper wrapper-content animated fadeInRight"
  }, "\n    	", HTML.DIV("\n    		", Spacebars.include(view.lookupTemplate("searchTemplate")), "\n    	"), "\n    	\n    	", HTML.DIV("\n    		", Spacebars.include(view.lookupTemplate("buttonTemplate")), "\n    	"), "\n    	\n    	", HTML.DIV("\n    		", Spacebars.include(view.lookupTemplate("addPostTemplate")), "\n    	"), HTML.Raw('\n    	\n    	<div id="resultsDiv">\n    	</div>\n    '));
}));

Template.__checkName("searchTemplate");
Template["searchTemplate"] = new Template("Template.searchTemplate", (function() {
  var view = this;
  return HTML.Raw('<form method="post">\n      <input type="text" name="searchContent">\n      <input type="submit" value="Find Post">\n   </form>');
}));

Template.__checkName("buttonTemplate");
Template["buttonTemplate"] = new Template("Template.buttonTemplate", (function() {
  var view = this;
  return HTML.Raw('<button class="button3" name="findMyPosts">Find My Posts</button>\n        <button class="button3" name="addNewPost">Add New Post</button>');
}));

Template.__checkName("addPostTemplate");
Template["addPostTemplate"] = new Template("Template.addPostTemplate", (function() {
  var view = this;
  return HTML.Raw('<form method="post">\n		<input type="text" name="title">\n		<input type="text" name="content">\n		<input type="submit" value="Post">\n	</form>');
}));

}).call(this);
