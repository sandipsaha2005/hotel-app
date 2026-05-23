import { createApp } from "./src/app.js";

const main = () => {
  const app = createApp();
  Deno.serve({ port: 8000, hostname: "0.0.0.0" }, app.fetch);
};
main();
