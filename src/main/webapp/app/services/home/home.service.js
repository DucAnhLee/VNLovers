app.factory("HomeService", ["$resource", function($resource) {
	return $resource("api/get-file/:url", {}, {
		'query': {method: 'GET', isArray: true},
        'get': {
            method: 'GET',
            transformResponse: function (data) {
                data = angular.fromJson(data);
                return data;
            }
        }
	})
}])