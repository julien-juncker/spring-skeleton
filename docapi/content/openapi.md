+++
title = "📑 OpenAPI"
date = "2025-04-28"
author = "julien-juncker"
weight = 1
+++

{{< ifenv env="development" >}}
    {{< openapi src="/openapi.yaml" >}}
{{< /ifenv >}}
{{< ifenv env="production" >}}
    {{< openapi src="./openapi.yaml" >}}
{{< /ifenv >}}