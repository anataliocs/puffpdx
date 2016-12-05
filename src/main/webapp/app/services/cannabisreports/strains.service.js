(function () {
    'use strict';

    angular
        .module('puffpdxApp')
        .factory('StrainsService', StrainsService);

    StrainsService.$inject = ['$resource'];

    function StrainsService($resource) {

        var service = $resource('/cannabisreports/strains?sort=test&page=1', {}, {
            'getStrains': {
                method: 'GET',
                transformResponse: function (data) {
                    data = angular.fromJson(data);
                    return data;
                }
            }
        });

        return service;
    }
})();
