import dotenv from "dotenv"
import path from "path"
import {createServiceConfig} from "@config/config"

dotenv.config({path: path.resolve(__dirname, "../../../../.env")})

const config = createServiceConfig("CATALOG_SERVICE_PORT", 3002)

export default config
