Template.dashboard1.helpers({

    // For demo purpose
    // Example of notification list
    notifications : [
        {number: 1, labelClass: 'success', content: 'Please contact me', time: '09:00 pm'},
        {number: 2, labelClass: 'info', content: 'Sign a contract', time: '10:16 am'},
        {number: 3, labelClass: 'primary', content: 'Open new shop', time: '08.22 pm'},
        {number: 4, labelClass: 'default', content: 'Call back to Sylvia', time: '11:06 pm'},
        {number: 5, labelClass: 'primary', content: 'Write a letter to Sandra', time: '12:00 pm'}
    ]

});

Template.dashboard1.rendered = function(){

    // Stocked horizontal bar

    new Chartist.Bar('#ct-chart4', {
        labels: ['Air China', 'Emirates', 'China Southern', 
        'China Eastern', 'Star Alliance', 'Singapore Airlines',
        'Hainan Airlines', 'Lufthansa', 'Cathay Pacific',
        'Sky Team Alliance'],
        series: [
            [0.66, 0.32, 0.21, 0.20, 0.18, 
            0.15, 0.13, 0.12, 0.11, 0.10]
        ]
    }, {
        seriesBarDistance: 2,
        reverseData: true,
        horizontalBars: true,
        axisY: {
            offset: 70
        }
    });
};