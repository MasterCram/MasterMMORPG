package Master_Cram.Master_Mod.gui;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import Master_Cram.Master_Mod.Master_Mod;
import Master_Cram.Master_Mod.inventory.BackpackInventory;
import Master_Cram.Master_Mod.inventory.ContainerCustomPlayer;
import Master_Cram.Master_Mod.inventory.InventoryCustomPlayer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

public class GuiCustomPlayerInventory extends GuiContainer
{
	/** x size of the inventory window in pixels. Defined as float, passed as int */
	private float xSize_lo;

	/** y size of the inventory window in pixels. Defined as float, passed as int. */
	private float ySize_lo;

	/** Normally I use '(ModInfo.MOD_ID, "textures/...")', but it can be done this way as well */
	private static final ResourceLocation iconLocation = new ResourceLocation("mm:textures/gui/custom_inventory_backpack.png");

	/** Could use IInventory type to be more generic, but this way will save an import... */
	private final IInventory inventory;
	
	private EntityPlayer player;

	public GuiCustomPlayerInventory(EntityPlayer player, InventoryPlayer inventoryPlayer, InventoryCustomPlayer 

			inventoryCustom, BackpackInventory backpackInventory, ItemStack[] itemList)
	{
		super(new ContainerCustomPlayer(player, inventoryPlayer, inventoryCustom, backpackInventory, itemList));
		this.inventory = inventoryCustom;
		this.player = player;
		this.xSize = 256;
		this.ySize = 165;
		// if you need the player for something later on, store it in a local variable here as well
	}
	
	public void onGuiClosed()
    {
		/*if(!player.worldObj.isRemote)
		{
			for(int i=0; i< 9;i++) {
				if(ContainerCustomPlayer.craftMatrix.getStackInSlot(i) != null)
				{
					ItemStack myItemStack = new ItemStack(ContainerCustomPlayer.craftMatrix.getStackInSlot(i).getItem(), ContainerCustomPlayer.craftMatrix.getStackInSlot(i).stackSize);
					EntityItem entityitem = new EntityItem(player.worldObj, player.posX, player.posY+1, player.posZ, myItemStack);
					if (myItemStack.hasTagCompound())
		            {
		                entityitem.getEntityItem().setTagCompound((NBTTagCompound)myItemStack.getTagCompound().copy());
		            }
					float f3 = 0.05F;
					entityitem.motionX = Master_Mod.random.nextGaussian() * (double)f3;
					entityitem.motionY = Master_Mod.random.nextGaussian() * (double)f3 + 0.20000000298023224D;
		            entityitem.motionZ = Master_Mod.random.nextGaussian() * (double)f3;
					player.worldObj.spawnEntityInWorld(entityitem);
				}
			}
		}*/
		
		super.onGuiClosed();
    }

	/**
	 * Draws the screen and all the components in it.
	 */
	public void drawScreen(int mouseX, int mouseY, float f)
	{
		super.drawScreen(mouseX, mouseY, f);
		xSize_lo = mouseX - 75;
		ySize_lo = mouseY;
	}

	/**
	 * Draw the foreground layer for the GuiContainer (everything in front of the items)
	 */
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		// This method will simply draw inventory names on the screen - you could do without it entirely
		// if that's not important to you, since we are overriding the default inventory rather than
		// creating a specific type of inventory
		String s = this.inventory.hasCustomInventoryName() ? this.inventory.getInventoryName() : " ";
		// with the name "Custom Inventory", the 'Cu' will be drawn in the first slot
		this.fontRendererObj.drawString(s, this.xSize - this.fontRendererObj.getStringWidth(s), 12, 4210752);
		// this just adds "Inventory" above the player's inventory below
		this.fontRendererObj.drawString(" ", 80, this.ySize - 96, 4210752);
	}

	/**
	 * Draw the background layer for the GuiContainer (everything behind the items)
	 */
	protected void drawGuiContainerBackgroundLayer(float f, int mouseX, int mouseY)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.getTextureManager().bindTexture(iconLocation);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		drawPlayerModel(guiLeft + 51, guiTop + 75, 30, guiLeft + 51 - xSize_lo, guiTop + 25 - ySize_lo, mc.thePlayer);
	}

	/**
	 * Copied straight out of vanilla - renders the player model on screen
	 */
	public static void drawPlayerModel(int x, int y, int scale, float yaw, float pitch, EntityLivingBase entity) {
		GL11.glEnable(GL11.GL_COLOR_MATERIAL);
		GL11.glPushMatrix();
		GL11.glTranslatef(x + 76, y, 50.0F);
		GL11.glScalef(-scale, scale, scale);
		GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
		float f2 = entity.renderYawOffset;
		float f3 = entity.rotationYaw;
		float f4 = entity.rotationPitch;
		float f5 = entity.prevRotationYawHead;
		float f6 = entity.rotationYawHead;
		GL11.glRotatef(135.0F, 0.0F, 1.0F, 0.0F);
		RenderHelper.enableStandardItemLighting();
		GL11.glRotatef(-135.0F, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(-((float) Math.atan(pitch / 40.0F)) * 20.0F, 1.0F, 0.0F, 0.0F);
		entity.renderYawOffset = (float) Math.atan(yaw / 40.0F) * 20.0F;
		entity.rotationYaw = (float) Math.atan(yaw / 40.0F) * 40.0F;
		entity.rotationPitch = -((float) Math.atan(pitch / 40.0F)) * 20.0F;
		entity.rotationYawHead = entity.rotationYaw;
		entity.prevRotationYawHead = entity.rotationYaw;
		GL11.glTranslatef(0.0F, entity.yOffset, 0.0F);
		RenderManager.instance.playerViewY = 180.0F;
		RenderManager.instance.renderEntityWithPosYaw(entity, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
		entity.renderYawOffset = f2;
		entity.rotationYaw = f3;
		entity.rotationPitch = f4;
		entity.prevRotationYawHead = f5;
		entity.rotationYawHead = f6;
		GL11.glPopMatrix();
		RenderHelper.disableStandardItemLighting();
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		OpenGlHelper.setActiveTexture(OpenGlHelper.lightmapTexUnit);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		OpenGlHelper.setActiveTexture(OpenGlHelper.defaultTexUnit);
	}
}
