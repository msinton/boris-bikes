package bikes

object ExpectedRouteAnalysisResults {

  val expectedFirstTenRows = Array(
    "Rental Id,Duration,Bike Id,End Date,EndStation Id,EndStation Name,Start Date,StartStation Id,StartStation Name",
    "9340768,1238,893,04/01/2012 00:20,169,Porchester Place: Paddington,04/01/2012 00:00,224,Whiteley's: Bayswater",
    "9345966,207,5621,04/01/2012 00:05,319,Baldwin Street: St. Luke's,04/01/2012 00:01,3,Christopher Street: Liverpool Street",
    "9349921,636,4365,04/01/2012 00:12,343,Gloucester Slips Car Park: Regent's Park,04/01/2012 00:01,311,Foley Street: Fitzrovia",
    "9341757,194,2708,04/01/2012 00:08,379,Turquoise Island: Notting Hill,04/01/2012 00:04,225,Notting Hill Gate Station: Notting Hill",
    "9344212,875,17,04/01/2012 00:20,340,Bank of England Museum: Bank,04/01/2012 00:05,88,Bayley Street : Bloomsbury",
    "9349769,2011,4879,04/01/2012 00:39,225,Notting Hill Gate Station: Notting Hill,04/01/2012 00:05,151,Chepstow Villas: Notting Hill",
    "9343209,1038,3278,04/01/2012 00:23,114,Park Road (Baker Street): Regent's Park,04/01/2012 00:06,49,Curzon Street: Mayfair",
    "9346348,1113,791,04/01/2012 00:25,33,Altab Ali Park: Whitechapel,04/01/2012 00:06,48,Godliman Street: St. Paul's",
    "9347774,1506,5903,04/01/2012 00:32,153,Bayswater Road: Hyde Park,04/01/2012 00:06,151,Chepstow Villas: Notting Hill"
  )

  val expectedMostPopularRoutes = Array(
    ("Hyde Park Corner, Hyde Park", "Hyde Park Corner, Hyde Park", 18186),
    ("Black Lion Gate: Kensington Gardens", "Black Lion Gate: Kensington Gardens", 12373),
    ("Albert Gate: Hyde Park", "Albert Gate: Hyde Park", 9831),
    ("Speakers' Corner 1: Hyde Park", "Speakers' Corner 1: Hyde Park", 6234),
    ("Speakers' Corner 2: Hyde Park", "Speakers' Corner 2: Hyde Park", 6017),
    ("Palace Gate: Kensington Gardens", "Palace Gate: Kensington Gardens", 5208),
    ("Hyde Park Corner, Hyde Park", "Albert Gate, Hyde Park", 4514),
    ("Black Lion Gate, Kensington Gardens", "Palace Gate, Kensington Gardens", 4381),
    ("Palace Gate, Kensington Gardens", "Black Lion Gate, Kensington Gardens", 3827),
    ("Hyde Park Corner, Hyde Park", "Black Lion Gate, Kensington Gardens", 3617)
  )

  val expectedMostPopularWithAverageJourney = Array(
    ("Hyde Park Corner, Hyde Park", "Hyde Park Corner, Hyde Park", 18186, "3216.99"),
    ("Black Lion Gate: Kensington Gardens", "Black Lion Gate: Kensington Gardens", 12373, "3103.88"),
    ("Albert Gate: Hyde Park", "Albert Gate: Hyde Park", 9831, "2648.47"),
    ("Speakers' Corner 1: Hyde Park", "Speakers' Corner 1: Hyde Park", 6234, "3408.83"),
    ("Speakers' Corner 2: Hyde Park", "Speakers' Corner 2: Hyde Park", 6017, "3271.76"),
    ("Palace Gate: Kensington Gardens", "Palace Gate: Kensington Gardens", 5208, "2765.30"),
    ("Hyde Park Corner, Hyde Park", "Albert Gate, Hyde Park", 4514, "2790.35"),
    ("Black Lion Gate, Kensington Gardens", "Palace Gate, Kensington Gardens", 4381, "1416.11"),
    ("Palace Gate, Kensington Gardens", "Black Lion Gate, Kensington Gardens", 3827, "1567.37"),
    ("Hyde Park Corner, Hyde Park", "Black Lion Gate, Kensington Gardens", 3617, "2332.55")
  )
}
