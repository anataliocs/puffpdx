(function() {
    'use strict';

    angular
        .module('puffpdxApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider.state('strains', {
            parent: 'app',
            url: '/strains',
            data: {
                authorities: [],
                pageTitle: 'Strains'
            },
            views: {
                'content@': {
                    templateUrl: 'app/strains/strains.html',
                    controller: 'StrainsController',
                    controllerAs: 'vm'
                }
            }
        });
    }
})();
