Template.postPage.onRendered(function() {
    $('#searchPostForm').submit(function(event) {
        event.preventDefault();
        var keyword = $('#keyword').val();
        console.log(keyword);
        HTTP.call(
            'GET',
            'http://localhost:9000/post/search/' + keyword,
            {},
            function(error, response) {
                if(error) {
                    console.log(error);
                } else {
                    console.log(response);
                }
            }
        );
    });
    
    function showResults(results) {
        var postsContainer = $('#postsContainer');
        if(results.length <= 0) {
        	postsContainer.empty();
			$('<p>', {
				className: 'noRecordsFound',
				html: 'No Results Were Found!'
			}).hide().appendTo(postsContainer).fadeIn();
        } else {
			var pageContainer = $('<div>', {
				className: 'pageContainer'
			});
			for (var i = 0; i < results.length; i++) {
				pageContainer.append(new result(results[i]) + '');
			}
            resultsDiv.empty();
			pageContainer.append('<div class="clear"></div>')
				.hide().appendTo(resultsDiv)
				.fadeIn('slow');
        }
    }
});
