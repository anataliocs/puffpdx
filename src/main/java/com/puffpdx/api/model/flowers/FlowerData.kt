package com.puffpdx.api.model.strains

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

/**
{
"name": "Critical Haze (Venus Genetics) - Flowers",
"ucpc": "FVA3D9XQDZ2WJVPNE3WY00000",
"link": "https://www.cannabisreports.com/api/v1.0/flowers/FVA3D9XQDZ2WJVPNE3WY00000",
"qr": "https://www.cannabisreports.com/flower-reports/qr-code/unknown-producer/venus-genetics/critical-haze-venus-genetics/flowers.png",
"barcode": "https://www.cannabisreports.com/flower-reports/barcode/unknown-producer/venus-genetics/critical-haze-venus-genetics/flowers.png",
"url": "https://www.cannabisreports.com/flower-reports/unknown-producer/venus-genetics/critical-haze-venus-genetics/flowers",
"image": "https://www.cannabisreports.com/images/strains/4/full_46e2dd566fedb32c23cdb866ea3b3f4ca46522b7.jpg",
"producer": {
"name": "Unknown Producer",
"ucpc": "00000000002WJVP0000000000",
"link": "https://www.cannabisreports.com/api/v1.0/producers/00000000002WJVP0000000000"
},
"type": "flowers",
"strain": {
"name": "Critical Haze (Venus Genetics)",
"ucpc": "FVA3D9XQDZ000000000000000",
"link": "https://www.cannabisreports.com/api/v1.0/strains/FVA3D9XQDZ000000000000000"
},
"labTest": false,
"thc": false,
"cbd": false,
"reviews": {
"count": 0,
"link": "https://www.cannabisreports.com/api/v1.0/flowers/FVA3D9XQDZ2WJVPNE3WY00000/reviews"
},
"createdAt": {
"datetime": "2016-12-04 20:22:24",
"timezone": "UTC"
},
"updatedAt": {
"datetime": "2016-12-04 21:08:31",
"timezone": "UTC"
}
}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class FlowerData {

    var name: String? = null
    var ucpc: String? = null
    var link: String? = null
    var qr: String? = null
    var image: String? = null

    var thc: String? = null
    var cbd: String? = null
}
