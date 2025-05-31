package command;

public class Help extends Command {
    /**
     * @return <code>String</code> all usable commands
     */
    @Override
    public String execute() {
        return "delete - Deletes your save file" +
                "\nend - Ends the game" +
                "\nequip - Lets you equip an armor or a weapon" +
                "\nequipment - Tells you what armor and weapon you're currently using" +
                "\nhelp - All commands" +
                "\nhistory - Returns all used commands" +
                "\ninventory - Returns your inventory" +
                "\nmove - Moves you into a new room" +
                "\nread - Increases your charisma/speech" +
                "\nsave - Saves the game" +
                "\nshop - Opens up the shop" +
                "\nsleep - Goes to sleep" +
                "\nstats - Tells you your important stats" +
                "\ntalk - Lets you talk with an NPC" +
                "\ntravel - Travels to a new map" +
                "\nuse - Lets you use an item";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
