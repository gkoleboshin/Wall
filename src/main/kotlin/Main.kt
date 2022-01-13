fun main(args: Array<String>) {
    post(0,0,0,0,12332,"HelloWorld!!!",0,false, comments = Comments(), copyright = Copyright(), likes = Likes(), reports = Reports(), views = Views(),"_",0,false,false,false,false,false,false, donut = Donut(),0)
}

fun post(id: Long,ownerId: Long,fromId: Long,createBy: Long,data: Int,text: String,replyOwnerId: Long,friendsOnly: Boolean,comments: Comments,copyright: Copyright,likes:Likes,reports: Reports,views: Views, postType: String,signerID: Long,canPin: Boolean,canDelete: Boolean,canEdit: Boolean,isPinned: Boolean,markedAsAds: Boolean,isFavorite: Boolean,donut: Donut,postponedID: Long){
    val post = Post(id,ownerId, fromId, createBy, data, text, replyOwnerId, friendsOnly, comments, copyright, likes, reports, views, postType, signerID, canPin, canDelete, canEdit, isPinned, markedAsAds, isFavorite, donut, postponedID)
    WallService.addPost(post)
}
object WallService{
    var posts = emptyArray<Post>()

    fun addPost(post:Post){
        posts+=post
        println(posts.last())
    }
}
data class Post(
                val id:Long,
                val ownerId:Long,
                val fromId:Long,
                val createBy:Long,
                val data:Int,
                val text:String,
                val replyOwnerId:Long,
                val friendsOnly:Boolean,
                val comments:Comments,
                val copyright: Copyright,
                val likes: Likes,
                val reports: Reports,
                val views: Views,
                val postType:String,
                val signerID:Long,
                val canPin:Boolean,
                val canDelete:Boolean,
                val canEdit:Boolean,
                val isPinned:Boolean,
                val markedAsAds:Boolean,
                val isFavorite:Boolean,
                val donut: Donut,
                val postponedID:Long
                )

class Comments()

class Copyright()

class Likes()

class Reports()

class Views()

class Donut()