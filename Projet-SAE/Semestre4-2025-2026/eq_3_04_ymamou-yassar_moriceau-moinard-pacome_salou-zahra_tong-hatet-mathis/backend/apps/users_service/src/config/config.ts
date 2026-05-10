import dotenv from "dotenv"
import path from "path"
import {createServiceConfig} from "@config/config"

dotenv.config({path: path.resolve(__dirname, "../../../../.env")})

const config = createServiceConfig("AUTH_SERVICE_PORT", 3001)

export default config
