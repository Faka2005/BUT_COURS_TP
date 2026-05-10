import {createApp} from "./app";
import config from "./config/config";
import mongoose from "mongoose";
import {MongoMemoryServer} from "mongodb-memory-server";
import {UserModel} from "./schema/user.schema";
import {loginUser, registerUser} from "./services/auth.service";
import {addOrUpdateAnimeIntoList, addToFavoriteById} from "./services/users.service";

main().catch((error) => {
	console.error("Fatal error:", error);
	process.exit(1);
});

async function main() {
	try {
		//mongo temp server
		const mongod = await MongoMemoryServer.create();
		const uri = mongod.getUri();
		await mongoose.connect(uri);

		//test insert user
		try {
			const user = {email: "mail@mail.com", username: "john", password: "jesuisbg"}
			await registerUser(user);
			const token = await loginUser({email: "mail@mail.com", password: "jesuisbg"});
			console.log(token.accessToken)
			console.log(token.sub)
			await addToFavoriteById(4224, token.sub as string)
			await addOrUpdateAnimeIntoList({
				animeId: 4224,
				rating: 10,
				userComment: "perfect",
			}, token.sub as string)
			await addOrUpdateAnimeIntoList({
				animeId: 20,
				rating: 5,
				userComment: "OK",
				status: "completed",
				isFavorite: false
			}, token.sub as string)
			await addOrUpdateAnimeIntoList({
				animeId: 6547,
				rating: 9,
				userComment: "Makes you cry",
				status: "completed",
				isFavorite: true
			}, token.sub as string)

		} catch (error) {
			console.error("Fatal error:", error);
			process.exit(1);
		}

	} catch (error) {
		console.error("Fatal error:", error);
		process.exit(1);
	}
	// start server
	const app = createApp();
	app.listen(config.port, config.host, () => {
		console.log(
			`[auth_service] listening on http://${config.host}:${config.port}`,
		);
	});
}
