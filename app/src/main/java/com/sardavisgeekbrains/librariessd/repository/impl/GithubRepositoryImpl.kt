package com.sardavisgeekbrains.librariessd.repository.impl

import com.sardavisgeekbrains.librariessd.model.GithubUser
import com.sardavisgeekbrains.librariessd.repository.GithubRepository

class GithubRepositoryImpl : GithubRepository {

    private val repositories = listOf(
        GithubUser ("Ivan"),
        GithubUser("Denis"),
        GithubUser("Andrey"),
        GithubUser("Yuri"),
        GithubUser("Dmitriy")
    )

    override fun getUsers() : List<GithubUser>{
        return repositories
    }
}