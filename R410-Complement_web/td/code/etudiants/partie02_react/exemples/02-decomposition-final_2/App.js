const formatDate = (date) => date.toLocaleDateString();
const comment = {
    date: new Date(),
    text: 'I hope you enjoy learning React!',
    author: {
        name: 'Hello Kitty',
        avatarUrl: 'https://cataas.com/cat',
    },
};

const Avatar = ({user}) =>
            <img
                className="Avatar"
                src={user.avatarUrl}
                alt={user.name}
            />


const UserInfo  = ({user}) =>
            <div className="UserInfo">
                <Avatar user={user}/>
                <div className="UserInfo-name">{user.name}</div>
            </div>


const  Comment = ({author,text,date}) =>
            <div className="Comment">
                <UserInfo user={author} />
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
