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

package com.paulrybitskyi.gamedge.igdb.api.datastore

import com.paulrybitskyi.gamedge.data.datastores.GamesDataStore
import com.paulrybitskyi.gamedge.data.utils.DataCompany
import com.paulrybitskyi.gamedge.data.utils.DataGame
import com.paulrybitskyi.gamedge.data.utils.DataStoreResult
import com.paulrybitskyi.gamedge.igdb.api.IgdbApi

class GamesDataStoreImpl(
    private val igdbApi: IgdbApi
) : GamesDataStore {


    override suspend fun searchGames(searchQuery: String, offset: Int, limit: Int): DataStoreResult<List<DataGame>> {
        return igdbApi
            .searchGames(searchQuery, offset, limit)
            .toDataStoreResult()
    }


    override suspend fun getPopularGames(offset: Int, limit: Int): DataStoreResult<List<DataGame>> {
        return igdbApi
            .getPopularGames(offset, limit)
            .toDataStoreResult()
    }


    override suspend fun getRecentlyReleasedGames(offset: Int, limit: Int): DataStoreResult<List<DataGame>> {
        return igdbApi
            .getRecentlyReleasedGames(offset, limit)
            .toDataStoreResult()
    }


    override suspend fun getComingSoonGames(offset: Int, limit: Int): DataStoreResult<List<DataGame>> {
        return igdbApi
            .getComingSoonGames(offset, limit)
            .toDataStoreResult()
    }


    override suspend fun getMostAnticipatedGames(offset: Int, limit: Int): DataStoreResult<List<DataGame>> {
        return igdbApi
            .getMostAnticipatedGames(offset, limit)
            .toDataStoreResult()
    }


    override suspend fun getCompanyGames(company: DataCompany, offset: Int, limit: Int): DataStoreResult<List<DataGame>> {
        return igdbApi
            .getCompanyGames(company.toApiCompany(), offset, limit)
            .toDataStoreResult()
    }


    override suspend fun getSimilarGames(game: DataGame, offset: Int, limit: Int): DataStoreResult<List<DataGame>> {
        return igdbApi
            .getSimilarGames(game.toApiGame(), offset, limit)
            .toDataStoreResult()
    }


}