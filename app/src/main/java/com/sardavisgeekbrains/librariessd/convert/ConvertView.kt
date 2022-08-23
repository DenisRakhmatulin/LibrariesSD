package com.sardavisgeekbrains.librariessd.convert

import android.net.Uri
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface ConvertView : MvpView {
    /**
     * Первичная инициализация элементов View при присоединении к Presenter
     */
    fun init()

    /**
     * Выводит исходное изображение
     * * @param uri - Uri оригинального изображения
     */
    fun showOriginImage(uri: Uri)

    /**
     * Выводит конвертированное изображение
     * @param uri - Uri результирующего изображения
     */
    fun showConvertedImage(uri: Uri)

    /**
     * Делает кнопку старта процесса конвертации активной
     */
    fun btnStartConvertEnable()

    /**
     * Деактивирует кнопку старта процесса конвертации
     */
    fun btnStartConvertDisabled()

    /**
     * Делает кнопку отмены процесса конвертации активной
     */
    fun btnAbortConvertEnabled()

    /**
     * Деактивирует кнопку отменты процесса конвертации
     */
    fun btnAbortConvertDisabled()

    /**
     * Показывает заглушку - флажок сигнализирующий о прерывании конвертации
     */
    fun signAbortConvertShow()

    /**
     * Скрывает заглушку - флажок сигнализирующий о прерывании конвертации
     */
    fun signAbortConvertHide()

    /**
     * Показывает заглушку - флажок призывающий начать чтото делать уже
     */
    fun signGetStartedShow()

    /**
     * Скрывает заглушку - флажок призывающий начать чтото делать...
     */
    fun signGetStartedHide()

    /**
     * Показывает заглушку - флажок ожидания действия...
     */
    fun signWaitingShow()

    /**
     * Скрывает заглушку - флажок ожидания действия...
     */
    fun signWaitingHide()

    /**
     * Показывает прогрессбар
     */
    fun showProgressBar()

    /**
     * Скрывает прогрессбар
     */
    fun hideProgressBar()

    /**
     * Показывает виджет ошибки
     */
    fun showErrorBar()

    /**
     * Скрывает виджет ошибки
     */
    fun hideErrorBar()
}