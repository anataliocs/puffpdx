package com.puffpdx.api.model.strains

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

/**
 * {
 * "name": "13 Roses",
 * "ucpc": "9XVU73HWRP000000000000000",
 * "link": "https://www.cannabisreports.com/api/v1.0/strains/9XVU73HWRP000000000000000",
 * "qr": "https://www.cannabisreports.com/strain-reports/unknown-breeder/13-roses/qr-code.svg",
 * "url": "https://www.cannabisreports.com/strain-reports/unknown-breeder/13-roses",
 * "image": "https://www.cannabisreports.com/images/strains/no_image.png",
 * "seedCompany": {
 * "name": "Unknown Breeder",
 * "ucpc": "9XVU700000000000000000000",
 * "link": "https://www.cannabisreports.com/api/v1.0/seed-companies/9XVU700000000000000000000"
 * },
 * "genetics": {
 * "names": "( X13 x Thai Landrace ) x Rosetta Stone",
 * "ucpc": "( 9XVU736RNE000000000000000 x 9XVU7NWEGH000000000000000 ) x 9XVU7DX36T000000000000000",
 * "link": "https://www.cannabisreports.com/api/v1.0/strains/9XVU73HWRP000000000000000/genetics"
 * },
 * "lineage": {
 * "Afghanistan": "AF",
 * "Colombia": "CO",
 * "India": "IN",
 * "Mexico": "MX",
 * "Thailand": "TH"
 * },
 * "children": {
 * "count": 6,
 * "link": "https://www.cannabisreports.com/api/v1.0/strains/9XVU73HWRP000000000000000/children"
 * },
 * "reviews": {
 * "count": 0,
 * "link": "https://www.cannabisreports.com/api/v1.0/strains/9XVU73HWRP000000000000000/reviews"
 * },
 * "createdAt": {
 * "datetime": "2016-02-26 22:25:48",
 * "timezone": "UTC"
 * },
 * "updatedAt": {
 * "datetime": "2016-02-26 22:25:48",
 * "timezone": "UTC"
 * }
 * }
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class StrainData {

    var name: String? = null
    var ucpc: String? = null
    var link: String? = null
    var qr: String? = null
    var image: String? = null
    var seedCompany: SeedCompany? = null
}
