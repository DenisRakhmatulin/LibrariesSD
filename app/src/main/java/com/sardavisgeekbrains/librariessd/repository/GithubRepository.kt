package com.sardavisgeekbrains.librariessd.repository

import com.sardavisgeekbrains.librariessd.model.GithubUser
import io.reactivex.rxjava3.core.Single

interface GithubRepository {
    fun getUsers() : Single<List<GithubUser>>
}