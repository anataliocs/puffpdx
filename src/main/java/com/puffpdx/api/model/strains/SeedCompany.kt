package com.puffpdx.api.model.strains

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

/**
 * "seedCompany": {
 * "name": "Unknown Breeder",
 * "ucpc": "9XVU700000000000000000000",
 * "link": "https://www.cannabisreports.com/api/v1.0/seed-companies/9XVU700000000000000000000"
 * }
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class SeedCompany {

    var name: String? = null
    var ucpc: String? = null
    var link: String? = null

}

