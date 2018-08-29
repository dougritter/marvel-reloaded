package com.dougritter.marvel.features.characters

/*
      "code": 200,
      "status": "Ok",
      "copyright": "© 2018 MARVEL",
      "attributionText": "Data provided by Marvel. © 2018 MARVEL",
      "attributionHTML": "<a href=\"http://marvel.com\">Data provided by Marvel. © 2018 MARVEL</a>",
      "etag": "e120e6f859b1967dabed0b95dd76ee087ebec101",
 */
data class ResponsePayload(val code: Int, val status: String, val copyright: String,
                           val attributionText: String, val attributionHTML: String,
                           val etag: String)