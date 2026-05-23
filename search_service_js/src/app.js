import { Hono } from "hono";
import { logger } from "hono/logger";
import { pool } from "./db/hotelsDB.js";
import { getCache, setCache } from "./db/redis.js";

export const createApp = () => {
  const app = new Hono();

  app.use(logger());

  app.get("/api/search/hotels", async (c) => {
    const city = c.req.query('city');

    try {
      const cacheData = await getCache(city);
      if (cacheData) {
        return c.json(cacheData);
      }

      await new Promise((res, rej) => {
        setTimeout(() => {
          res(1);
        }, 5000);
      });

      const res = await pool.query("SELECT * FROM hotels WHERE city = $1", [
        city,
      ]);

      await setCache(city, res.rows, 60);

      return c.json(res.rows);
    } catch (err) {
      console.error("Error executing query", err.stack);
      return c.json({ success: false });
    }
  });

  return app;
};
