const formatDate = (date) => date.toLocaleDateString();
const comment = {
    date: new Date(),
    text: 'I hope you enjoy learning React!',
    author: {
        name: 'Hello Kitty',
        avatarUrl: 'https://cataas.com/cat',
    },
};

class Avatar extends React.Component{
    render() {
        return (
            <img
                className="Avatar"
                src={this.props.user.avatarUrl}
                alt={this.props.user.name}
            />
        );
    }
}

class UserInfo extends React.Component{
    render() {
        return (
            <div className="UserInfo">
                <Avatar user={this.props.user}/>
                <div className="UserInfo-name">{this.props.user.name}</div>
            </div>
        );
    }
}


class Comment extends React.Component {
    render() {
        return (
            <div className="Comment">
                <UserInfo user={this.props.author} />
                <div className="Comment-text">{this.props.text}</div>
                <div className="Comment-date">
                    {formatDate(this.props.date)}
                </div>
            </div>
        );
    }
}



const root = ReactDOM.createRoot(document.querySelector('#app_container'));
root.render(
    <Comment
        date={comment.date}
        text={comment.text}
        author={comment.author}
    />
);
