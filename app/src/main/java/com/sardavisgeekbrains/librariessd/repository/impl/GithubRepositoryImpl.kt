package com.sardavisgeekbrains.librariessd.repository.impl

import com.sardavisgeekbrains.librariessd.model.GithubUser
import com.sardavisgeekbrains.librariessd.repository.GithubRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import java.util.concurrent.TimeUnit

class GithubRepositoryImpl : GithubRepository {

    private val repositories = listOf(
        GithubUser("Ivan"),
        GithubUser("Denis"),
        GithubUser("Andrey"),
        GithubUser("Yuri"),
        GithubUser("Dmitriy")
    )

    override fun getUsers(): Single<List<GithubUser>> {
        return Single.create {
            it.onSuccess(repositories)
        }.delay(1000, TimeUnit.MILLISECONDS)
            .observeOn(AndroidSchedulers.mainThread())
    }
}