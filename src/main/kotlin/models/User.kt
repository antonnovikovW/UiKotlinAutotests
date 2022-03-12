package models

data class User(
    val companyName: String = "",
    val name: String = "",
    val email: String,
    val phone: String = "",
) {
}