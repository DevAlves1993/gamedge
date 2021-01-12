/*
 * Copyright 2020 Paul Rybitskyi, paul.rybitskyi.work@gmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.paulrybitskyi.gamedge.data.auth.datastores.local

import com.paulrybitskyi.gamedge.data.auth.DataOauthCredentials

internal class AuthMapper(private val authExpiryTimeCalculator: AuthExpiryTimeCalculator) {


    fun mapToProtoOauthCredentials(oauthCredentials: DataOauthCredentials): ProtoOauthCredentials {
        return ProtoOauthCredentials.newBuilder()
            .setAccessToken(oauthCredentials.accessToken)
            .setTokenType(oauthCredentials.tokenType)
            .setTokenTtl(oauthCredentials.tokenTtl)
            .setExpirationTime(authExpiryTimeCalculator.calculateExpiryTime(oauthCredentials))
            .build()
    }


    fun mapToDataOauthCredentials(oauthCredentials: ProtoOauthCredentials): DataOauthCredentials {
        return DataOauthCredentials(
            accessToken = oauthCredentials.accessToken,
            tokenType = oauthCredentials.tokenType,
            tokenTtl = oauthCredentials.tokenTtl
        )
    }


}