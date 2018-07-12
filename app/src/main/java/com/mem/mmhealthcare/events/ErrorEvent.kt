package com.mem.mmhealthcare.events

class ErrorEvent {

    class ApiErrorEvent(val throwable: Throwable? = null){
        fun getMsg(): String? {
            return if (throwable == null)
                "Null Throwable in Error"
            else
                throwable.message
        }
    }
}