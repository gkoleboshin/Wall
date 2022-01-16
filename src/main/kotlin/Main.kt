
fun main() {
    post(0,0,0,getDate(),"HelloWorld!!!",0,false, comments = Comments(), copyright = Copyright(), likes = Likes(), reports = Reports(), views = Views(),"_",0,false,false,false,false,false,false, donut = Donut(),0)
    post(0,0,0,getDate(),"HelloWorld2!!!",0,false, comments = Comments(), copyright = Copyright(), likes = Likes(), reports = Reports(), views = Views(),"_",0,false,false,false,false,false,false, donut = Donut(),0)
    postUpdate(2,1,1,1,text = "Hello World 2022!!!", replyOwnerId = 0, friendsOnly = true , comments = Comments(), copyright = Copyright(), likes = Likes(), reports = Reports(), views = Views(), postType = "_", signerID =  0, canPin = false, canEdit =  false, canDelete = false, isPinned =  false, markedAsAds =  false, isFavorite =  false, donut = Donut(), postponedID = 0)
}

fun getDate():Long{
    val date:Long= System.currentTimeMillis()/1000L
    return date
}

fun post(ownerId: Long,fromId: Long,createBy: Long,date: Long,text: String,replyOwnerId: Long,friendsOnly: Boolean,comments: Comments,copyright: Copyright,likes:Likes,reports: Reports,views: Views, postType: String,signerID: Long,canPin: Boolean,canDelete: Boolean,canEdit: Boolean,isPinned: Boolean,markedAsAds: Boolean,isFavorite: Boolean,donut: Donut,postponedID: Long){
    val post = Post(id = 0,ownerId, fromId, createBy, date, text, replyOwnerId, friendsOnly, comments, copyright, likes, reports, views, postType, signerID, canPin, canDelete, canEdit, isPinned, markedAsAds, isFavorite, donut, postponedID)
    println(WallService.add(post))
}
fun postUpdate(id:Long,ownerId: Long,fromId: Long,createBy: Long,date: Long = 0L,text: String,replyOwnerId: Long,friendsOnly: Boolean,comments: Comments,copyright: Copyright,likes:Likes,reports: Reports,views: Views, postType: String,signerID: Long,canPin: Boolean,canDelete: Boolean,canEdit: Boolean,isPinned: Boolean,markedAsAds: Boolean,isFavorite: Boolean,donut: Donut,postponedID: Long){
    val editPost = Post(id,ownerId,fromId,createBy,0L,text,replyOwnerId,friendsOnly,comments,copyright,likes,reports,views, postType,signerID,canPin,canDelete,canEdit,isPinned,markedAsAds,isFavorite,donut,postponedID)
    println(WallService.editPost(editPost))
}

object WallService{
    var posts = emptyArray<Post>()
    var havePosts = false

    fun add(post:Post):Post{
        var postWithId:Post
        if (!havePosts){
            postWithId = post.copy(id= post.id+1)
            havePosts=true
        }else{
            postWithId = post.copy(id= posts.last().id+1)
        }
        posts+= postWithId
        return posts.last()
    }
    fun editPost(post:Post):Boolean{
        for((index,oldPost) in posts.withIndex()){
            if (oldPost.id == post.id) {
                posts.set(index,post.copy(date = oldPost.date))
                println(posts.get(index))
                return true
            }
        }
        return false
    }
}
data class Post(
    val id:Long = 0,
    val ownerId:Long,
    val fromId:Long,
    val createBy:Long,
    val date:Long,
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
    var canEdit:Boolean,
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