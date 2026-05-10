const formatDate = (date) => date.toLocaleDateString();
const comment = {
    date: new Date(),
    text: 'I hope you enjoy learning React!',
    author: {
        name: 'Hello Kitty',
        avatarUrl: 'https://cataas.com/cat',
    },
};

class Comment extends React.Component {
    render() {
        return (
            <div className="Comment">
                <div className="UserInfo">
                    <img
                        className="Avatar"
                        src={this.props.author.avatarUrl}
                        alt={this.props.author.name}
                    />
                    <div className="UserInfo-name">
                        {this.props.author.name}
                    </div>
                </div>
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
