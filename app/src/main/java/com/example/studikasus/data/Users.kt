package com.example.studikasus.data

class Users {
    var username: String? = null
    var email: String? = null
    var password: String? = null

    constructor() {}
    constructor(username: String?, email: String?, password: String?) {
        this.username = username
        this.email = email
        this.password = password
    }
}