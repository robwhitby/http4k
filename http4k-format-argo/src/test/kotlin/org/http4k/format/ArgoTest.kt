package org.http4k.format

import argo.jdom.JsonNode
import argo.jdom.JsonRootNode
import org.http4k.http.formats.JsonContract
import org.http4k.http.formats.JsonErrorResponseRendererContract

class ArgoTest : JsonContract<JsonRootNode, JsonNode>(Argo)
class ArgoJsonErrorResponseRendererContractTest : JsonErrorResponseRendererContract<JsonRootNode, JsonNode>(Argo)