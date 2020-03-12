package kaleidot725.sample.data.entity

data class User(
    val description: String,
    val facebook_id: String,
    val followees_count: Int,
    val followers_count: Int,
    val github_login_name: String,
    val id: String,
    val items_count: Int,
    val linkedin_id: String,
    val location: String,
    val name: String,
    val organization: String,
    val permanent_id: Int,
    val profile_image_url: String,
    val team_only: Boolean,
    val twitter_screen_name: String,
    val website_url: String
)

val nullUser = User("", "", 0, 0, "", "", 0, "", "", "", "", 0, "", false, "", "")