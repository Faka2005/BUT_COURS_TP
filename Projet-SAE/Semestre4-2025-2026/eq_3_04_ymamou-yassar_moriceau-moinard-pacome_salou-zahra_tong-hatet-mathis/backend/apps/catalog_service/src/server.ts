import {createApp} from "./app";
import config from "./config/config";
import mongoose from "mongoose";
import {MongoMemoryServer} from "mongodb-memory-server";


main().catch((error) => {
	console.error("Fatal error:", error);
	process.exit(1);
});

async function main() {
	const mongod = await MongoMemoryServer.create();
	const uri = mongod.getUri();
	await mongoose.connect(uri);
	// start server
	const app = createApp();
	app.listen(config.port, config.host, () => {
		console.log(
			`[catalogue_service] listening on http://${config.host}:${config.port}`,
		);
	});
}
