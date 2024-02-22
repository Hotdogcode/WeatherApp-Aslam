package com.hdc.domain.architecture.exception

abstract class DomainException(
    open val throwable: Throwable
):Exception(throwable) {
    constructor(msg:String):this(Exception(msg))
}