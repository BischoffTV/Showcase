# Showcase Plugin

The `Showcase` plugin, developed under the package `org.bischoff.showcase`, is a feature-rich addition to your Minecraft server that integrates with the PlotSquared API. It provides enhanced control over plot-related events, specifically focusing on block placement and inventory interactions.

## Key Features

1. **Block Placement Monitoring**: The plugin monitors the placement of trapped chests and hoppers. If a player places either of these blocks on a plot they own, and the block is named "Showcase", the state of the block is updated.

2. **Block Break Restriction**: The plugin restricts players from breaking trapped chests and hoppers placed on plots they do not own. This helps maintain the integrity of each player's plot and prevents unauthorized modifications.

3. **Inventory Interaction Control**: The plugin controls inventory interactions with trapped chests and hoppers named "Showcase". If a player who does not own the plot tries to interact with the inventory of these blocks, the action is cancelled.

The `Showcase` plugin is a powerful tool for servers using the PlotSquared system, providing players with a secure and personalized building experience.
