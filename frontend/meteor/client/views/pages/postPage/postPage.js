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
});
