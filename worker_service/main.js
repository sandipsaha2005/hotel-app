import { redisServer } from "./src/redis_server.js";
import {generatePDF} from "./src/generate_pdf.js"

const main =  async() => {
  const client = await redisServer()
  await generatePDF(client)
}

main();