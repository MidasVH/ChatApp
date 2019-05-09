package domain;

public class Comment {
    private int commentId;
    private String name;
    private String post;
    private int rating;

    public Comment(int commentId, String name, String post, int rating){
        setCommentId(commentId);
        setName(name);
        setPost(post);
        setRating(rating);
    }

    public Comment(){}

    public void setCommentId(int commentId){
        if(commentId < 0 || commentId > 5){
            throw new DomainException("id not valid");
        }
        this.commentId = commentId;
    }

    public void setName(String name){
        if(name.trim().isEmpty())
            throw new DomainException("name can't be empty");
        this.name = name;
    }

    public void setPost(String post){
        if(post.trim().isEmpty())
            throw new DomainException("Post cannot be empty");
        this.post = post;
    }

    public void setRating(int rating){
        if(rating < 0 || rating > 5)
            throw new DomainException("Rating must be between 0 and 5");
        this.rating = rating;
    }

    public int getCommentId(){
        return commentId;
    }

    public String getName(){
        return name;
    }

    public String getPost(){
        return post;
    }

    public int getRating(){
        return rating;
    }
}
