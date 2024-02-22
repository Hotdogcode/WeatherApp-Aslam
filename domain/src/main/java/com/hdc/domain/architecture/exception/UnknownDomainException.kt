package com.hdc.domain.architecture.exception

class UnknownDomainException(throwable: Throwable):DomainException(throwable) {
    constructor(err:String):this(Throwable(err))
}