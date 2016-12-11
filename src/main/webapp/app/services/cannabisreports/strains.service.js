(function () {
    'use strict';

    angular
        .module('puffpdxApp')
        .factory('StrainsService', StrainsService);

    StrainsService.$inject = ['$resource'];

    function StrainsService($resource) {

        var service = $resource('/cannabisreports/strains?sort=:sort&page=:page', {}, {
            'getStrains': {
                method: 'GET',
                params:{
                    sort:'test',
                    page: 'page'
                },
                transformResponse: function (data) {
                    data = angular.fromJson(data);
                    return data;
                }
            }
        });

        return service;
    }
})();
