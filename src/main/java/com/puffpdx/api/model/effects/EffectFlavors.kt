package com.puffpdx.api.model.effects

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
class EffectFlavors {

    var euphoria: String? = null
    var creativity: String? = null
    var calming: String? = null
    var numbness: String? = null
    var appetite_gain: String? = null
    var dry_mouth: String? = null
    var fruity: String? = null
    var spicy: String? = null
    var earthy: String? = null
    var sour: String? = null
    var sweet: String? = null
    var pine: String? = null
    var anxiety: String? = null
    var reviews: String? = null

}
