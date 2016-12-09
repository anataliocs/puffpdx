package com.puffpdx.api.model.strains

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.puffpdx.api.model.common.Metadata

/**

 */
@JsonIgnoreProperties(ignoreUnknown = true)
class Flowers {
    var data: List<FlowerData>? = null
    var meta: Metadata? = null
}
