<!DOCTYPE html>
<html>
<head>
    <title>Add Schedule</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
</head>
<body>
    <h2>Enter Schedule Details</h2>
    <form action="/addSchedule" method="POST">
        <label id="source">Source</label>
        &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
        <input type="text" name="source" id="source">
        <br>

        <label id="destination">Destination</label>
        &nbsp&nbsp
        <input type="text" name="destination" id="destination">
        <br>

        <label id="starttime">Start Time</label>
        &nbsp&nbsp&nbsp
        <input type="text" name="startTime" id="starttime">
        <br>

        <label id="arrivaltime">Arrival Time</label>
        &nbsp
        <input type="text" name="arrivalTime" id="source">
        <br>

        <input type="hidden" name="operation" value="newSchedule">

        <input type="submit" value="Create Schedule">
        
    </form>
</body>
</html>