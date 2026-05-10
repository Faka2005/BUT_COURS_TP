const formatDate = (date) => date.toLocaleDateString();
const comment = {
    date: new Date(),
    text: 'I hope you enjoy learning React!',
    author: {
        name: 'Hello Kitty',
        avatarUrl: 'https://cataas.com/cat',
    },
};

const Comment = ({author,date,text})=>
            <div className="Comment">
                <div className="UserInfo">
                    <img
                        className="Avatar"
                        src={author.avatarUrl}
                        alt={author.name}
                    />
                    <div className="UserInfo-name">
                        {author.name}
                    </div>
                </div>
                <div className="Comment-text">{text}</div>
                <div className="Comment-date">
                    {formatDate(date)}
                </div>
            </div>




const root = ReactDOM.createRoot(document.querySelector('#app_container'));
root.render(
    <Comment
        date={comment.date}
        text={comment.text}
        author={comment.author}
    />
);
