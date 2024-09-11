package com.example.feature_message.domain

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

private const val DATE = "Date"
private val dateFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
private val dateTimeFormat = SimpleDateFormat("HH:mm  dd.MM.yyyy", Locale.getDefault())
private val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())


/** Преобразует дату в строку с точностью до дня */
fun Date.convertToTheDay(): String =
    dateFormat.format(this)

/** Конвертирует дату в строку с точностью до минуты */
fun Date.convertToTheMinuteAndDate(): String =
    dateTimeFormat.format(this)

/** Конвертирует дату в строку с точностью до минуты */
fun Date.convertToTheMinute(): String =
    timeFormat.format(this)
