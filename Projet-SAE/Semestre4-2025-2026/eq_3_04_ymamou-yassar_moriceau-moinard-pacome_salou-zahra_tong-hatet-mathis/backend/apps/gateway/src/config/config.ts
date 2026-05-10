import dotenv from "dotenv"
import path from "path"
import {createServiceConfig} from "@config/config"

dotenv.config({path: path.resolve(__dirname, "../../../../.env")})

const config = createServiceConfig("GATEWAY_PORT", 3000)

export default config
