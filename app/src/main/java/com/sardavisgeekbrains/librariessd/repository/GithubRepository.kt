package com.sardavisgeekbrains.librariessd.repository

import com.sardavisgeekbrains.librariessd.model.GithubUser

interface GithubRepository {
    fun getUsers() : List<GithubUser>
}