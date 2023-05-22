package ru.nikolaev.icerockgithubviewer.data.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query
import ru.nikolaev.icerockgithubviewer.data.entities.Repo
import ru.nikolaev.icerockgithubviewer.data.entities.RepoDetails
import ru.nikolaev.icerockgithubviewer.data.entities.RepoReadme
import ru.nikolaev.icerockgithubviewer.data.entities.UserInfo

interface GithubApi {

    @GET("user")
    suspend fun getUserInfo(
        @Header("Authorization") authHeader: String,
    ): Response<UserInfo>

    @GET("users/{userName}/repos")
    suspend fun getRepositoriesList(
        @Path("userName") userName: String,
        @Query("sort") sortBy: String = "updated",
        @Header("Authorization") authHeader: String,
    ): Response<List<Repo>>

    @GET("repos/{owner}/{repoName}")
    suspend fun getRepositoryDetails(
        @Path("owner") ownerName: String,
        @Path("repoName") repoName: String,
        @Header("Authorization") authHeader: String,
    ): Response<RepoDetails>

    @GET("repos/{owner}/{repoName}/readme")
    suspend fun getRepositoryReadme(
        @Path("owner") ownerName: String,
        @Path("repoName") repoName: String,
        @Query("ref") branchName: String,
        @Header("Authorization") authHeader: String,
    ): Response<RepoReadme>
}