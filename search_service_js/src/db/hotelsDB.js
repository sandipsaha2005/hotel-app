import { Pool } from "pg";

export const pool = new Pool({
  user: Deno.env.get('POSTGRES_USER') || "postgres",
  host: 'postgres',
  database: Deno.env.get("POSTGRES_DB") || 'hotels',
  password: Deno.env.get("POSTGRES_PASSWORD") || 'password',
  port: 5432,
});

async function insertHotel() {
  const text = `
    INSERT INTO hotels (name, city, price, owner, owner_email) 
    VALUES ($1, $2, $3, $4, $5) 
    RETURNING id;
  `;

  const values = [
    ['Sunset Resort1', 'Los Angeles', 3020.00, 'Alice Green', 'alice1@example.com'],
    ['Sunset Resort2', 'Visakhapatnam', 6320.00, 'Alice Green', 'alice2@example.com'],
    ['Sunset Resort3', 'KKD', 220.00, 'Alice Green', 'alice3@example.com'],
  
    ['Ocean Breeze Inn', 'Mumbai', 4500.00, 'Rahul Sharma', 'rahul1@example.com'],
    ['Royal Stay', 'Mumbai', 5200.00, 'Priya Mehta', 'priya1@example.com'],
    ['City Comfort Hotel', 'Delhi', 3100.00, 'Arjun Patel', 'arjun1@example.com'],
    ['Grand Palace Suites', 'Delhi', 7200.00, 'Neha Kapoor', 'neha1@example.com'],
    ['Hill View Residency', 'Bangalore', 2800.00, 'Kiran Rao', 'kiran1@example.com'],
    ['Urban Nest Hotel', 'Bangalore', 3900.00, 'Sneha Iyer', 'sneha1@example.com'],
    ['Blue Lagoon Resort', 'Chennai', 6100.00, 'Vikram Singh', 'vikram1@example.com'],
    ['Palm Tree Hotel', 'Chennai', 3400.00, 'Anjali Verma', 'anjali1@example.com'],
    ['Golden Tulip Inn', 'Hyderabad', 4700.00, 'Rakesh Kumar', 'rakesh1@example.com'],
    ['Skyline Residency', 'Hyderabad', 5300.00, 'Pooja Nair', 'pooja1@example.com'],
    ['Emerald Bay Hotel', 'Pune', 4100.00, 'Manoj Reddy', 'manoj1@example.com'],
    ['Comfort Crown', 'Pune', 3600.00, 'Divya Sharma', 'divya1@example.com'],
    ['Sea Pearl Resort', 'Visakhapatnam', 6900.00, 'Suresh Babu', 'suresh1@example.com'],
    ['Harbor Lights Hotel', 'Visakhapatnam', 5400.00, 'Lavanya Devi', 'lavanya1@example.com'],
    ['Green Valley Stay', 'KKD', 1800.00, 'Teja Varma', 'teja1@example.com'],
    ['Riverfront Residency', 'KKD', 2100.00, 'Bhavana Rao', 'bhavana1@example.com'],
    ['Mountain Bliss Inn', 'Goa', 8500.00, 'Amit Joshi', 'amit1@example.com'],
    ['Beachside Retreat', 'Goa', 9100.00, 'Nisha Menon', 'nisha1@example.com'],
    ['Silver Oak Hotel', 'Kolkata', 3300.00, 'Deepak Sen', 'deepak1@example.com'],
    ['Metro Palace', 'Kolkata', 4700.00, 'Ritu Das', 'ritu1@example.com'],
    ['Sunrise Residency', 'Jaipur', 2900.00, 'Harish Gupta', 'harish1@example.com'],
    ['Royal Heritage Inn', 'Jaipur', 6500.00, 'Meera Jain', 'meera1@example.com'],
  ];

  try {

    for (let i = 0; i < values.length; i++) {
      const res = await pool.query(text, values[i]);
      console.log(`Hotel inserted successfully with ID: ${res.rows[0].id}`);
    }

  } catch (err) {
    console.error('Error inserting data:', err.stack);
  } finally {
    // await pool.end();
  }
}

// insertHotel();